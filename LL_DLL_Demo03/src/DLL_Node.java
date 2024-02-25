/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NC
 */
public class DLL_Node {
    Flower flower;
    DLL_Node next;
    DLL_Node previous;

    public DLL_Node(Flower f) {
        this.flower = f;
        next = previous = null;
    }
    public DLL_Node(String name , String original, int price){
        this(new Flower(name, original, price));
    }
    
}
