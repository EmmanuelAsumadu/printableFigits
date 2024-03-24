import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.ChamferedCube

// code here
double linkX = 12.7;//mm
double linkY = 2.66;
double linkZ = 4.00;
double champThickness=1.35;
double champher =champThickness/2-0.05
 CSG crossBar = new ChamferedCube(
	linkX, 
	linkY,
	champThickness, 
	champher
	).toCSG()
CSG bottomLeft = crossBar.rotz(90).movex(-linkX/2)
CSG bottomRight =crossBar.rotz(90).movex(linkX/2)
CSG theBottom = crossBar.union(bottomRight).union(bottomLeft).toZMin()
CSG theTop= theBottom.rotz(90).toZMax().movez(linkZ)
CSG post =new ChamferedCube(linkY,linkY,linkZ,champher).toCSG()
		.toZMin()
return[theBottom,theTop,post];
