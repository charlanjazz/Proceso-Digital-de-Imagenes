/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.filters.basic.controller;

import com.filters.main.Editor;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author chars
 */
@ManagedBean(name="mosaic")
@ViewScoped
public class MosaicController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManagedProperty(value="#{editor}")
    private Editor editor;
    
    private int t;
    
    public MosaicController() {
        this.t = 10;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public void aplicar() {
        if (t <= 0 ) {
            editor.reset();
            return;
        }
        editor.setImg(mosaico(t, editor.getImg2()));
    }
    
    public static BufferedImage mosaico(int tam, BufferedImage img){
        //Recorre las imagenes y obtiene el color de la imagen original y la almacena en el destino.
        int w = img.getWidth(), h = img.getHeight(), x = 0, y = 0, r = 0, g = 0, b = 0, m = 0, n = 0;
        // crea un buffer local para no alterar el buffer que recibe
        BufferedImage bi = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        while (x < w){
            m = ((x + tam) < w)? tam : w - x;
            while (y < h){
                n = ((y + tam) < h)? tam : h - y;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++){
                        Color c = new Color(img.getRGB(i + x, j + y));
                        r += c.getRed(); g += c.getGreen(); b += c.getBlue();
                    }
                } r /= (m * n); g /= (m * n); b /= (m * n);
                //Se aplica el color promedio del mosaico.
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) bi.setRGB(i + x, j + y, new Color(r, g, b).getRGB());
                } y += n; r = 0; g = 0; b = 0;
            } x += m; y = 0;
        } return bi;
    }
}
