/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.mfo.jsurf.rendering;

import javax.vecmath.*;

/**
 *
 * @author Christian Stussak <christian at knorf.de>
 */
public class LightProducts
{
    private LightSource lightSource;
    public void setLightSource(LightSource lightSource)
    {
        this.lightSource= lightSource;
    }

    public void setMaterial(Material material)
    {
        this.material= material;
    }

    public void setSpecularProduct(Color3f specularProduct)
    {
        this.specularProduct= specularProduct;
    }

    private Material material;
    private Color3f diffuseProduct;
    private Color3f specularProduct;
    
    public LightProducts()
    {
    }

    public LightProducts(LightSource lightSource, Material material)
    {
	this.lightSource= lightSource;
	this.material= material;

	this.diffuseProduct= new Color3f(material.getColor());
	this.diffuseProduct.x*= lightSource.getColor().x;
	this.diffuseProduct.y*= lightSource.getColor().y;
	this.diffuseProduct.z*= lightSource.getColor().z;
	this.diffuseProduct.scale(material.getDiffuseIntensity() * lightSource.getIntensity());

	this.specularProduct= new Color3f(lightSource.getColor());
	this.specularProduct.scale(material.getSpecularIntensity() * lightSource.getIntensity());
    }

    public LightSource getLightSource()
    {
	return this.lightSource;
    }

    public Material getMaterial()
    {
	return this.material;
    }

    public Color3f getDiffuseProduct()
    {
	return this.diffuseProduct;
    }

    public Color3f getSpecularProduct()
    {
	return this.specularProduct;
    }
}
