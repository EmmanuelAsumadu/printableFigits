import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.ChamferedCube

// code here
double linkX = 12.7;//mm
double linkY = 2.66;
double linkZ = 4.00;
double champThickness=1.35;
double champher =champThickness/2-0.05
double movement = -linkX/2;
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
CSG post1= post.movex(movement).movey(movement)
CSG post2= post.movex(-movement).movey(-movement)
CSG post3=post.movex(movement).movey(-movement)
CSG post4=post.movex(-movement).movey(movement)
CSG allUnion =CSG.unionAll(theBottom,theTop,post,post1,post2,post3,post4)
def list =[]
for (int row=0; row<12; row++) 
{
	for(int col=0; col<12; col++ )
	{
		CSG tryNew = allUnion.movex((movement*1.5)*row).movey((movement*1.5)*col)
		
		list.add(tryNew)
	}
}
return list;
