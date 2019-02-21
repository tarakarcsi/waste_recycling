import java.awt.print.Paper;

public class Dustbin {

    String _color;
    PaperGarbage[] _paperContent;
    PlasticGarbage[] _plasticContent;
    Garbage[] _houseWasteContent;

    public Dustbin(String color) {
        _color = color;
        _paperContent = new PaperGarbage[0];
        _plasticContent = new PlasticGarbage[0];
        _houseWasteContent = new Garbage[0];
    }

    public PaperGarbage[] getpaperContent(){
        return _paperContent;
    }

    public PlasticGarbage[] getplasticContent(){
        return _plasticContent;
    }

    public Garbage[] getHouseWasteContent(){
        return _houseWasteContent;
    }

    public void displayContent() {

        System.out.println(_color + "Dustbin!\n");
        System.out.println("House waste content: " + _houseWasteContent.length + "item(s)\n");
        for(int i = 0; i < _houseWasteContent.length; i++) {
            System.out.println(_houseWasteContent[i] + "\n");
        }
        System.out.println("Peper content: " + _paperContent.length + "item(s)\n");
        for(int i = 0; i < _paperContent.length; i++) {
            System.out.println(_paperContent[i] + "\n");
        }
        System.out.println("Plastic content: " + _plasticContent.length + "item(s)\n");
        for(int i = 0; i < _plasticContent.length; i++) {
            System.out.println(_plasticContent[i] + "\n");
        }

    }

    public void throwOutGarbage(Garbage garbage) throws DustbinContentException {

        if(garbage instanceof PlasticGarbage) {
            PlasticGarbage plasticGarbage = (PlasticGarbage)garbage;
            if (plasticGarbage.isClean()) {
                //PlasticGarbage newItem = plasticGarbage;

                int currentSize = _plasticContent.length;
                int newSize = currentSize + 1;

                PlasticGarbage[] tempArray = new PlasticGarbage[newSize];
                for (int i = 0; i < currentSize; i++){
                    tempArray[i] = _plasticContent[i];
                }
                tempArray[newSize - 1] = plasticGarbage;
                _plasticContent = tempArray;
                }
        }

        else if(garbage instanceof PaperGarbage) {
            PaperGarbage paperGarbage = (PaperGarbage)garbage;
            if(paperGarbage.isSqueezed()) {
                //PaperGarbage newItem = paperGarbage;

                int currentSize = _paperContent.length;
                int newSize = currentSize + 1;

                PaperGarbage[] tempArray = new PaperGarbage[newSize];
                for(int i = 0; i < currentSize; i++) {
                    tempArray[i] = _paperContent[i];
                }
                tempArray[newSize - 1] = paperGarbage;
                _paperContent = tempArray; 
            }
        }

        else if(garbage instanceof Garbage) {
            //Garbage newItem = garbage;
            int currentSize = _houseWasteContent.length;
            int newSize = currentSize + 1;
            Garbage[] tempArray = new Garbage[newSize];
            for (int i = 0; i < currentSize; i++){
                tempArray[i] = _houseWasteContent[i];
            }
            tempArray[newSize - 1] = garbage;
            _houseWasteContent = tempArray;  
        }

        else {
            throw new DustbinContentException();
        }

    }

    public void emptyContents() {

        _paperContent = null;
        _plasticContent = null;
        _houseWasteContent = null;
    }
}
