/** Class has methods that are used to find a path from start to end
 * 
 * @author Hemming
 *
 */
public class Path {
	Map cityMap;

/** Constructor sets instance variable cityMap to chosen block
 * 
 * @param theMap The chosen block
 */
	
public Path(Map theMap) {
	cityMap = theMap;
}

/** Method finds a path to the destination using helper method nextCell()
 * 
 */

public void findPath() {
	ArrayStack<MapCell> s = new ArrayStack<MapCell>(200,200,50);
	MapCell Current_Cell = this.cityMap.getStart();
	s.push(Current_Cell);
	Current_Cell.markInStack();
	while (!s.isEmpty() && !s.peek().isDestination()) {
		Current_Cell = s.peek();
		if(Current_Cell.isDestination()) {		
	}
		else {
			Current_Cell = nextCell(Current_Cell);
			if (Current_Cell == null) {
				MapCell Bad_Cell = s.pop();
				Bad_Cell.markOutStack();
			}
			else {
				if (Current_Cell.isMarked()) {
					MapCell Bad_Cell = s.pop();
					Bad_Cell.markOutStack();
				}
				else {
					s.push(Current_Cell);
					Current_Cell.markInStack();
				}
			}
		}
	}
	if(s.size() == 0) {
		System.out.println("No path found");
	}
	else {
	System.out.println("Path found containing " + s.size() + " cell(s)");
	}
}

/** Helper method that determines the best block to move to given a starting block
 *  
 * @param cell The starting block
 * @return New block (the best avaliable block)
 */
private MapCell nextCell(MapCell cell) {
	MapCell Return_Container = null;
	for (int i=0 ; i < 4 ; i++ ) {
		MapCell Neighbour_Cell = cell.getNeighbour(i);
		if(Neighbour_Cell != null && Neighbour_Cell.isDestination()) {
		return Neighbour_Cell;
		}
	}
	for (int j=0 ; j < 4 ; j++ ) {
		MapCell Neighbour_Cell = cell.getNeighbour(j);
		if (Neighbour_Cell != null && Neighbour_Cell.isIntersection() && !Neighbour_Cell.isMarked()) {
		return Neighbour_Cell;		
		}
	}
	for (int k=0 ; k < 4 ; k++ ) {
		MapCell Neighbour_Cell = cell.getNeighbour(k);
		if (Neighbour_Cell != null && !Neighbour_Cell.isMarked() && (Neighbour_Cell.isNorthRoad() || Neighbour_Cell.isEastRoad() || Neighbour_Cell.isSouthRoad() || Neighbour_Cell.isWestRoad())) {
			if (k==0 && Neighbour_Cell.isNorthRoad()) {
			return Neighbour_Cell;
			}
			else if (k==1 && Neighbour_Cell.isEastRoad()) {
			return Neighbour_Cell;
			}
			else if (k==2 && Neighbour_Cell.isSouthRoad()) {
			return Neighbour_Cell;
			}
			else if (k==3 && Neighbour_Cell.isWestRoad()) {
			return Neighbour_Cell;
			}
		}
		

}
	return Return_Container;
}
}
