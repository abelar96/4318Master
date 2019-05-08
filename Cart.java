import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    private ArrayList<LineItem> items;



    public Cart (){
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void addItem(LineItem item) {

        String code = item.getProduct().getProductID();
        int quantity = item.getQuantity();

        for (int i =0; i<items.size(); i++){
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductID().equals(code)){
                lineItem.setQuantity(quantity);
                lineItem.setTotal();
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item){
        String code = item.getProduct().getProductID();
        for (int i=0;i<items.size();i++){
            LineItem lineItem = items.get(i);
            if(lineItem.getProduct().getProductID().equals(code)){
                items.remove(i);
                return;
            }

        }
    }

}
