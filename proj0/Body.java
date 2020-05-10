
public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Body(double xP, double yP, double xV,
		           double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass =  m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass =  b.mass;
		imgFileName = b.imgFileName;
	}

	/** calculate the distance between the taken body and the given body. */
	public double calcDistance(Body b) {
		double xDist = b.xxPos - xxPos;
		double yDist = b.yyPos - yyPos;
		double distance =  Math.sqrt(xDist * xDist + yDist * yDist);
		return distance;  
	}

	/** calsulate the force exerted on the taken body by the given body. */
	public double calcForceExertedBy(Body b) {
		double graviConst = 6.67e-11;
		double force = graviConst * mass * b.mass / Math.pow(calcDistance(b), 2);
		return force; 
	}

	/** calsulate the force in the X and Y directions. */
	public double calcForceExertedByX(Body b) {
		double forceX = calcForceExertedBy(b) * (b.xxPos - xxPos) / calcDistance(b);
		return forceX; 
	}

	public double calcForceExertedByY(Body b) {
		double forceY = calcForceExertedBy(b) * (b.yyPos - yyPos) / calcDistance(b);
		return forceY; 
	}

	/** calsulate the net X and net Y force exerted by all bodies. */
	public double calcNetForceExertedByX(Body[] allBodys) {
		double netForceX = 0;
		for (int i = 0; i < allBodys.length; i++) {
			if (allBodys[i].equals(this)) {
				continue;
			}
			netForceX += calcForceExertedByX(allBodys[i]);
		}
		return netForceX; 
	}

	public double calcNetForceExertedByY(Body[] allBodys) {
		double netForceY = 0;
		for (int i = 0; i < allBodys.length; i++) {
			if (allBodys[i].equals(this)) {
				continue;
			}
			netForceY += calcForceExertedByY(allBodys[i]);
		}
		return netForceY; 
	}

	/** update the velocity and position. */
	public void update(double dt, double fX, double fY) {
		double aNetX = fX / mass;
		double aNetY = fY / mass;
		xxVel += dt * aNetX;
		yyVel += dt * aNetY;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;
	}

	/** draw the Body' image.*/
	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}

}