import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter implements ActionListener {
    GUI_Restoran view1;
    Aplikasi model;
    
    public Controller(){
        view1 = new GUI_Restoran();
        model = new Aplikasi();
        view1.addActionListener(this);
        view1.addMouseAdapter(this);
        view1.setVisible(true);
        view1.setRestoId(Restoran.getSid());
        view1.resetView();
        view1.setListRestoId(model.getRestoListId());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        
        if (source.equals(view1.getBtnDaftarResto())){
            try{
                String id = view1.getRestoId();
                String name = view1.getRestoName();
                Restoran r = new Restoran(id, name);
                model.addRestoran(r);
            }catch (Exception e){
                System.out.println(e);
            }
            view1.resetView();
            view1.setRestoId(Restoran.getSid());
            view1.setListRestoId(model.getRestoListId());
        }
    }
    
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view1.getListRestoId())){
            String id = view1.getSelectedRestoId();
            view1.setRestoString(model.searchResto(id));
        }
    }
}
