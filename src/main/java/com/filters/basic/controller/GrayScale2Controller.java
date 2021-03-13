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
@ManagedBean(name="gs2")
@ViewScoped
public class GrayScale2Controller implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManagedProperty(value="#{editor}")
    private Editor editor;

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }
    
    public void aplicar() {
        editor.setImg(grayScale2(editor.getImg2()));
    }
    
    public BufferedImage grayScale2(BufferedImage img){
        // saca la medida ancho y alto del buffer que recibe
        int w = img.getWidth(); int h = img.getHeight();
        // crea un buffer local para no alterar el buffer que recibe
        BufferedImage bi = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        // recorre los pixeles del buffer 
        for(int i = 0; i<w; i++){
            for(int j = 0; j<h; j++){
                // obtiene el color del pixel
                Color c = new Color(img.getRGB(i, j));
                // obtiene el balance en gris
                int gs = (int)((c.getRed() * 0.3) + (c.getGreen() * 0.59) + (c.getBlue() * 0.11));
                c = new Color(gs,gs,gs);
                // se aplica el balance en gris
                bi.setRGB(i,j,c.getRGB());
            }
        }
        return bi;
    }
}
