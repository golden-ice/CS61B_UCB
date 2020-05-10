

public class NBody {
	/** read and return the radius. */
	public static double readRadius(String file) {
		//"./data/planets.txt"
		In in = new In(file);
		in.readInt();
		double radius = in.readDouble();
		return radius;		
	}

	/** read and return the bodies. */
	public static Body[] readBodies(String file) {
		//"./data/planets.txt"
		In in = new In(file);
		int num = in.readInt();
		in.readDouble();
		Body[] bodies = new Body[num];
		int i = 0;
		while(i < num) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			bodies[i] = new Body(xP, yP, xV, yV, m, img);
			i += 1;
		}
		return bodies;		
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Body[] bodies = readBodies(filename);
		Double radius = readRadius(filename);


		/** drawing the background. */
		StdDraw.setScale(-radius, radius);
		//StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");

		/* draw the bodies*/
		for (Body body : bodies) {
			body.draw();
		}

		/** Avoid flickering. */
		StdDraw.enableDoubleBuffering();

		double t = 0.0;
		while (t <= T) {
			/** Create xForces and yForces. */
			double[] xForces = new double[bodies.length];  
			double[] yForces = new double[bodies.length];

			/** Calculate and store net x and y forces for each body in bodies.*/
			for (int i = 0; i < bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}

			/** Update each body. */
			for (int i = 0; i < bodies.length; i++) {
				bodies[i].update(dt, xForces[i], yForces[i]);
			}

			/** Draw the background. */
			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");
			
			/** Draw all the bodies. */
			for (Body body : bodies) {
			    body.draw();
		    }
			StdDraw.show();
			StdDraw.pause(10);
			t = t + dt;		
		}

		/** Print the universe when the simulation is over. */
		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
						  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
						  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
		}
	}
}