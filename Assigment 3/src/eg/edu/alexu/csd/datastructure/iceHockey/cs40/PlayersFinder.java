package eg.edu.alexu.csd.datastructure.iceHockey.cs40;

import java.awt.Point;

public class PlayersFinder implements IPlayersFinder {
	
	public static int MAXPHOTO=50;
	public static int MAXPTHRESH=1000;
	public static int i=0, j=0, count=0, xMax=0, yMax=0, xMin=0, yMin=0 ;
	
	public static void search(String photo[],int x1, int y1, int length, int width, int team) {
		int x2=x1,y2=y1, num;
		x2=x2+1;
		y2=y1;
		while(x2>=x1-1) {
			if(x2==i) {
				x2--;
			}
			else{
				if(x2==length) {
					x2--;
					continue;
				}
				if(x2==x1) {
					x2--;
					continue;
				}
				if(x2==-1) {
					break;
				}
				num=Character.getNumericValue(photo[x2].charAt(y2));
				if(num==team) {
					photo[x2]= photo[x2].substring(0,y2)+ '*' + photo[x2].substring(y2+1);
					if(x2>xMax) {
						xMax=x2;
					}
					if(x2<xMin) {
						xMin=x2;
					}
					search(photo, x2,y2,length, width, team);
					count++;
				}
				x2--;
			}
		}
		x2=x1;
		y2=y2+1;
		while(y2>=y1-1) {
			if(y2==j) {
				y2--;
			}
			else{
				if(y2==width) {
					y2--;
					continue;
				}
				if(y2==y1) {
					y2--;
					continue;
				}
				if(y2==-1) {
					break;
				}
				num=Character.getNumericValue(photo[x2].charAt(y2));
				if(num==team) {
					photo[x2]= photo[x2].substring(0,y2)+ '*' + photo[x2].substring(y2+1);
					if(y2>yMax) {
						yMax=y2;
					}
					if(y2<yMin) {
						yMin=y2;
					}
					search(photo, x2,y2,length, width, team);
					count++;
				}
				y2--;
			}
		}
	}

	public static void sortArray(int array[][], int k) {
		int temp;
		for(int i=0; i<k-1; i++) {
			for(int j=0; j<k-i-1;j++) {
				if(array[j][0]>array[j+1][0]) {
					temp=array[j][0];
					array[j][0]=array[j+1][0];
					array[j+1][0]=temp;
					temp=array[j][1];
					array[j][1]=array[j+1][1];
					array[j+1][1]=temp;
				}
			}
		}
		for(i=0; i<k-1; i++) {
			if(array[i][0]==array[i+1][0]) {
				if(array[i][1]>array[i+1][1]) {
					temp=array[i][1];
					array[i][1]=array[i+1][1];
					array[i+1][1]=temp;
				}
			}
		}
	}
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		int num;
		if(photo.length==0) {
			return null;
		}
		else if(photo.length==1) {
			if(photo[0]==null){
				return null;
			}
		}
		int counter=0;
		int array[][][]=new int [photo.length][photo[0].length()][5];
		for(i=0; i<photo.length; i++) {
			for(j=0; j<photo[i].length();j++) {
				count=0;
				xMin=i;
				yMin=j;
				xMax=i;
				yMax=j;
				num=Character.getNumericValue(photo[i].charAt(j));
				if(num==team) {
					photo[i]= photo[i].substring(0,j)+ '*' + photo[i].substring(j+1);
					search(photo,i,j,photo.length, photo[i].length(), team);
					count++;
					array[i][j][0]=xMin;
					array[i][j][1]=xMax;
					array[i][j][2]=yMin;
					array[i][j][3]=yMax;
					array[i][j][4]=count;
					counter++;
				}
			}
		}
		int preFinal[][]=new int [counter][2];
		int k=0;
		for(i=0; i<photo.length; i++) {
			for(j=0;j<photo[i].length();j++) {
				if((array[i][j][4]*4)>=threshold) {
					preFinal[k][1]=array[i][j][0]+array[i][j][1]+1;
					preFinal[k][0]=array[i][j][2]+array[i][j][3]+1;
					k++;
				}
			}
		}
		int Final[][]=new int[k][2];
		for(i=0; i<k; i++) {
			Final[i][0]=preFinal[i][0];
			Final[i][1]=preFinal[i][1];
		}
		sortArray(Final,k);
		Point [] places=new Point[k];
		for(i=0; i<k; i++) {
			places[i]=new Point();
			places[i].x=Final[i][0];
			places[i].y=Final[i][1];
		}
		return places;
	}
	
	
	public static void main(String args[]) {
	}
}
