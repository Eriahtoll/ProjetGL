package Code.View;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.EventDispatchChain;
import javafx.scene.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Paint;
import javafx.util.Callback;

import java.util.Stack;


public class CalculatorGUI extends Scene implements CalculatorGUIInterface{
    private Buttons buttons;

    public CalculatorGUI(Parent parent, Buttons buttons) {
        super(parent);
        this.buttons = buttons;
    }

    @Override
    public void affiche() {

    }
    @Override
    public void changeaccu(String accu) {

    }

    @Override
    public void changestack(Stack Pile) {

    }
    public CalculatorGUI(Parent parent) {
        super(parent);
    }

    public CalculatorGUI(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

    public CalculatorGUI(Parent parent, Paint paint) {
        super(parent, paint);
    }

    public CalculatorGUI(Parent parent, double v, double v1, Paint paint) {
        super(parent, v, v1, paint);
    }

    public CalculatorGUI(Parent parent, double v, double v1, boolean b) {
        super(parent, v, v1, b);
    }

    public CalculatorGUI(Parent parent, double v, double v1, boolean b, SceneAntialiasing sceneAntialiasing) {
        super(parent, v, v1, b, sceneAntialiasing);
    }

    @Override
    public WritableImage snapshot(WritableImage writableImage) {
        return super.snapshot(writableImage);
    }

    @Override
    public void snapshot(Callback<SnapshotResult, Void> callback, WritableImage writableImage) {
        super.snapshot(callback, writableImage);
    }

    @Override
    public Node lookup(String s) {
        return super.lookup(s);
    }

    @Override
    public void addMnemonic(Mnemonic mnemonic) {
        super.addMnemonic(mnemonic);
    }

    @Override
    public void removeMnemonic(Mnemonic mnemonic) {
        super.removeMnemonic(mnemonic);
    }

    @Override
    public ObservableMap<KeyCombination, ObservableList<Mnemonic>> getMnemonics() {
        return super.getMnemonics();
    }

    @Override
    public ObservableMap<KeyCombination, Runnable> getAccelerators() {
        return super.getAccelerators();
    }

    @Override
    public EventDispatchChain buildEventDispatchChain(EventDispatchChain eventDispatchChain) {
        return super.buildEventDispatchChain(eventDispatchChain);
    }

    @Override
    public Dragboard startDragAndDrop(TransferMode... transferModes) {
        return super.startDragAndDrop(transferModes);
    }

    @Override
    public void startFullDrag() {
        super.startFullDrag();
    }

    @Override
    public boolean hasProperties() {
        return super.hasProperties();
    }

    @Override
    public void setUserData(Object o) {
        super.setUserData(o);
    }

    @Override
    public Object getUserData() {
        return super.getUserData();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }




}
