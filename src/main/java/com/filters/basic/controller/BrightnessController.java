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
@ManagedBean(name="brightness")
@ViewScoped
public class BrightnessController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int level;
    @ManagedProperty(value="#{editor}")
    private Editor editor;
    
    public BrightnessController() {
        level= 0;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public void aplicar() {
        editor.setImg(brightness(level, editor.getImg2()));
    }
    
    private BufferedImage brightness(int level, BufferedImage img){
        // saca la medida ancho y alto del buffer que recibe
        int w = img.getWidth(); int h = img.getHeight();
        // crea un buffer local para no alterar el buffer que recibe
        BufferedImage bi = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        // recorre los pixeles del buffer 
        for(int i = 0; i<w; i++){
            for(int j = 0; j<h; j++){
                // obtiene el color del pixel del buffer que recibe
                Color c = new Color(img.getRGB(i, j));
                // altera el color del pixel en un rango adecuado
                int r = c.getRed() + level;    r = r > 255 ? 255 : r <  0 ? 0 : r;
                int g = c.getGreen() + level;  g = g > 255 ? 255 : g <  0 ? 0 : g;
                int b = c.getBlue() + level;   b = b > 255 ? 255 : b <  0 ? 0 : b;
                // modifica el color
                c = new Color(r,g,b);
                // aplica el color modificado al pixel en el buffer local 
                bi.setRGB(i,j,c.getRGB());
            }
        }
        // regresa el buffer local
        return bi;
    }
}
