public class PaperGarbage extends Garbage {

    boolean _isSqueezed = false;

    public PaperGarbage(String name, boolean isSqueezed){
        super(name);
        _isSqueezed = isSqueezed;
    }

    public void squeeze(){
        _isSqueezed = true;
    }

    public boolean isSqueezed(){
        if(_isSqueezed == true){
            return true;
        }
        else {
            return false;
        }
    }

}
