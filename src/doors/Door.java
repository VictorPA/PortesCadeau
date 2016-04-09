package doors;

/**
 * Created by Victor on 08/04/2016.
 */
public class Door {

    private boolean chosen;
    private boolean gifted;
    private boolean opened;


    public Door(String name){
        this.resetDoor();
    }


    public void resetDoor(){

        this.chosen = false;
        this.gifted = false;
        this.opened = false;

    }

    public boolean isChosen() {
        return chosen;
    }

    public void choose() {
        this.chosen = true;
    }


    public boolean isGifted() {
        return gifted;
    }

    public void gift(){
        this.gifted = true;
    }


    public boolean isOpened() {
        return opened;
    }

    public void open(){
        this.opened = true;
    }
    public void close(){
        this.opened = false;
    }

    public void setOpened() {
        this.opened = true;
    }
}
