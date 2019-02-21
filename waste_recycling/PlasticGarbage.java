public class PlasticGarbage extends Garbage {

    boolean _isClean = false;

    public PlasticGarbage(String name, boolean isClean) {
        super(name);
        _isClean = isClean;
    }

    public void clean(){
        _isClean = true;
    }

    public boolean isClean() {
        if(_isClean == true) {
            return  true;
        }
        else {
            return false;
        }
    }
}
