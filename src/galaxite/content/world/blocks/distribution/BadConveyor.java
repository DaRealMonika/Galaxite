package galaxite.content.world.blocks.distribution;

import arc.math.Mathf;
import mindustry.type.Item;
import mindustry.world.blocks.distribution.Conveyor;

public class BadConveyor extends Conveyor {
    public BadConveyor(String name){
        super(name);
    }

    public class BadConveyorBuild extends ConveyorBuild{
        public boolean pass(Item item){
            if (item != null && this.next != null && this.next.team == this.team && (this.next.acceptItem(this, item) && Mathf.chance(0.5f))) {
                this.next.handleItem(this, item);
                return true;
            }
            return false;
        }
    }
}