package com.example.littepro_ldealweight;

public class WeightCalculate {
	public float maleCalculate(float height){
		float idealWeight = (float) ((height-80)*0.7);
		return idealWeight;
		
	}
	
	public float femaleCalculate(float height){
		float idealWeight = (float) ((height-70)*0.6);
		return idealWeight;
	}
	
}
