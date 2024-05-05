//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
River r=new River("Niles","1.2332,3.343/1.4555,5.6666/4.34,5.675");
r.stringCoordinates();

Layer l=new Layer();
l.addElements(new Park("Raiganj Municipal Park",3.4444,4.555));
l.addElements(r);
l.renderLayer();

    }
    }
