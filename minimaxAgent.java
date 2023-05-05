import java.io.*;
import java.awt.Point;
import java.util.*;


class minimaxAgent{

	int depth;
	int x;
	public minimaxAgent(int depth)
	{
		this.depth = depth;
	}	

	public int getAction(State st) throws CloneNotSupportedException
	{
		 minimax(st, depth, false);
		 return x;
	}
	public double max_value(State st, int d) throws CloneNotSupportedException
	{
		ArrayList<Integer> children = new ArrayList<Integer>();
		double z;
		if(d == 0)
		return st.evaluationFunction();
		else{
		children = st.getLegalActions();
		double v = -10000000;

		for(int i =0; i<children.size();i++){
			v=Math.max(v , min_value(st.generateSuccessor('O',children.get(i), d ,st ) , d));
			this.x=i;}
		    return v;
		}
	}
	public double min_value(State st, int d ) throws CloneNotSupportedException
	{

		ArrayList<Integer> children = new ArrayList<Integer>();
		if(d == 0)
		return st.evaluationFunction();
		else
		{
		children = st.getLegalActions();
		double v = 10000000;
		//int x=0;

		for(int i =0; i<children.size();i++){
			v=Math.min(v , max_value(st.generateSuccessor('O',children.get(i), d-1 ,st ) , d));
			this.x=i;
		}
		return v;
		}
	}


	public double minimax(State st ,int d , boolean flag) throws CloneNotSupportedException{
		ArrayList<Integer> children = new ArrayList<Integer>();
		double v;
		double z;
		if(d == 0)
		return st.evaluationFunction();
		if(flag){
			v=-10000;
			for(int i =0; i<children.size();i++){
				z=Math.max(v , minimax(st.generateSuccessor('O',children.get(i), d-1 ,st ) , d-1 , false));
				if(z <= v){
						v=z;
				    this.x=i;
				}
				}
			return v;
		}
		else {
				 v=10000;
				for(int i =0; i<children.size();i++){
					z=Math.min(v , minimax(st.generateSuccessor('O',children.get(i), d-1 ,st ) , d-1 , true));
					if(z <= v){
						v=z;
				    this.x=i;
				}
			}
				
			}
			return v;
		}
	}

