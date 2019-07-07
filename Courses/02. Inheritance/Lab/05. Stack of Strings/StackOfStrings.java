import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public String peek() {
        if(!isEmpty()){
            return this.data.get(data.size()-1);
        }

        return null;
    }

    public String pop(){
        String element = null;
        if(!isEmpty()){
             element = this.data.get(data.size()-1);
             this.data.remove(data.size()-1);
        }

        return element;
    }
}
