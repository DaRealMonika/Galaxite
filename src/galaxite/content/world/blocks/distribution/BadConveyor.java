package galaxite.content.world.blocks.distribution;

import mindustry.type.Item;
import mindustry.world.blocks.distribution.Conveyor;

public class BadConveyor extends Conveyor {
    public BadConveyor(String name){
        super(name);
    }

    public class BadConveyorBuild extends ConveyorBuild{/*
        public pass(Item item){
            if (item != null && this.next)
        }*/
    }
}