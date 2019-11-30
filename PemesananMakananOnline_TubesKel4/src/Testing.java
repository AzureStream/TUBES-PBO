/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Testing {
    public static void main(String[] args) {
        Aplikasi a = new Aplikasi();
        a.loadPengemudi();
        Pengemudi p = a.searchAvailPengemudi();
        System.out.println(p.getNama());
        
    }
}
