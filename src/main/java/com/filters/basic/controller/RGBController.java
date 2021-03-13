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
import javax.faces.bean.SessionScoped;

/**
 *
 * @author chars
 */
@ManagedBean(name="rgb")
@SessionScoped
public class RGBController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private boolean r;
    private boolean g;
    private boolean b;
    
    @ManagedProperty(value="#{editor}")
    private Editor editor;
    
    public RGBController() {
        this.r = this.g = this.b = true;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }
    
    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }

    public boolean isG() {
        return g;
    }

    public void setG(boolean g) {
        this.g = g;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
    
    public void aplicar(){
        editor.setImg(rgb(r, g, b, editor.getImg2()));
    }
    
    public static BufferedImage rgb(boolean r, boolean g, boolean b, BufferedImage img){
        // saca la medida ancho y alto del buffer que recibe
        int w = img.getWidth(); int h = img.getHeight();
        // crea un buffer local para no alterar el buffer que recibe
        BufferedImage bi = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        // recorre los pixeles del buffer 
        for(int i = 0; i<w; i++){
            for(int j = 0; j<h; j++){
            // obtiene el color del pixel del buffer que recibe
            Color c = new Color(img.getRGB(i, j));
            // altera el color rgb del pixel según sean seleccionados 
            c = new Color(r ? c.getRed() : 0, g ? c.getGreen() : 0, b ? c.getBlue() : 0);
            // aplica los colores en el pixel del buffer local
            bi.setRGB(i,j,c.getRGB());
          }
        }
        // regresa el buffer local
        return bi;
    }
}
