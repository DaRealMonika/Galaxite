package galaxite.content.world.blocks.power;

import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.EnumSet;
import arc.util.Nullable;
import arc.util.io.*;
import mindustry.content.Fx;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.LAccess;
import mindustry.ui.Bar;
import mindustry.world.blocks.payloads.*;
import mindustry.world.meta.BlockFlag;

import static mindustry.Vars.*;

public class PayloadDecayGenerator extends PayloadBlock {
    public Float maxPayloadSize = 3f;
    public Float deconstructSpeed = 2.5f;

    public PayloadDecayGenerator(String name){
        super(name);
        outputsPayload = false;
        acceptsPayload = true;
        hasPower = true;
        outputsPower = true;
        consumesPower = false;
        hasItems = false;
        rotate = false;
        solid = true;
        size = 3;
        payloadSpeed = 1f;
        clipSize = 120;
        flags = EnumSet.of(BlockFlag.generator);
    }

    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{region, topRegion};
    }

    @Override
    public void setBars(){
        super.setBars();

        addBar("progress", (PayloadDecayGeneratorBuild e) -> new Bar("bar.progress", Pal.ammo, () -> e.progress));
    }

    public class PayloadDecayGeneratorBuild extends PayloadBlockBuild<Payload> {
        public @Nullable Payload deconstructing;
        public @Nullable float[] accum;
        public float progress;
        public float time, speedScl;

        @Override
        public void draw(){
            Draw.rect(region, x, y);

            //draw input
            for(int i = 0; i < 4; i++){
                if(blends(i)){
                    Draw.rect(inRegion, x, y, (i * 90) - 180);
                }
            }

            Draw.z(Layer.blockOver);
            drawPayload();
            if(deconstructing != null){
                deconstructing.set(x + payVector.x, y + payVector.y, payRotation);

                Draw.z(Layer.blockOver);
                deconstructing.drawShadow(1f - progress);

                //TODO looks really bad
                Draw.draw(Layer.blockOver, () -> {
                    Drawf.construct(x, y, deconstructing.icon(), Pal.remove, deconstructing instanceof BuildPayload ? 0f : payRotation - 90f, 1f - progress, 1f - progress, time);
                    Draw.color(Pal.remove);
                    Draw.alpha(1f);

                    Lines.lineAngleCenter(x + Mathf.sin(time, 20f, tilesize / 2f * block.size - 3f), y, 90f, block.size * tilesize - 6f);

                    Draw.reset();
                });
            }

            Draw.rect(topRegion, x, y);
        }

        @Override
        public boolean canControlSelect(Unit unit) {
            return unit.type.allowedInPayloads && this.payload == null && this.acceptUnitPayload(unit) && unit.tileOn() != null && unit.tileOn().build == this;
        }

        @Override
        public boolean acceptUnitPayload(Unit unit){
            return payload == null && deconstructing == null && unit.type.allowedInPayloads && unit.hitSize / tilesize <= maxPayloadSize;
        }

        @Override
        public void handlePayload(Building source, Payload payload){
            super.handlePayload(source, payload);
            accum = null;
        }

        @Override
        public boolean acceptPayload(Building source, Payload payload){
            return deconstructing == null && this.payload == null && super.acceptPayload(source, payload) && payload.fits(maxPayloadSize);
        }

        public float payHealth(Payload p){
            if (p instanceof UnitPayload) {
                return ((UnitPayload) p).unit.health;
            } else if (p instanceof BuildPayload) {
                return ((BuildPayload) p).build.health;
            }
            return 0;
        }

        @Override
        public void updateTile(){
            super.updateTile();

            if(deconstructing == null){
                progress = 0f;
            }

            payRotation = Angles.moveToward(payRotation, 90f, payloadRotateSpeed * edelta());

            if(deconstructing != null){
                //check if there is health for deconstruction
                boolean canProgress = payHealth(deconstructing) > 0;
                if(canProgress){
                    float shift = edelta() * deconstructSpeed / deconstructing.buildTime();
                    progress += shift;
                    time += edelta();
                }

                speedScl = Mathf.lerpDelta(speedScl, canProgress ? 1f : 0f, 0.1f);

                power.graph.transferPower(0.6f);

                //finish deconstruction, prepare for next payload.
                if(canProgress){
                    Fx.breakBlock.at(x, y, deconstructing.size() / tilesize);

                    deconstructing = null;
                    accum = null;
                }
            }else if(moveInPayload(false) && payload != null){
                accum = new float[payload.requirements().length];
                deconstructing = payload;
                payload = null;
                progress = 0f;
            }
        }

        @Override
        public double sense(LAccess sensor){
            if(sensor == LAccess.progress) return progress;
            return super.sense(sensor);
        }

        @Override
        public boolean shouldConsume(){
            return deconstructing != null && enabled;
        }

        @Override
        public void write(Writes write){
            super.write(write);

            write.f(progress);
            if(accum != null){
                write.s(accum.length);
                for(float v : accum){
                    write.f(v);
                }
            }else{
                write.s(0);
            }
            Payload.write(deconstructing, write);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);

            progress = read.f();
            short accums = read.s();
            if(accums > 0){
                accum = new float[accums];
                for(int i = 0; i < accums; i++){
                    accum[i] = read.f();
                }
            }
            deconstructing = Payload.read(read);
        }
    }
}