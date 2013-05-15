/*
/ Classes needing implementation because of this one
/   VectorMapItemData
/     public int x,y,type;
/   TimedItemAdder extends TimerTask


public class GameMap extends Drawable {
  public const int EMPTY = 0;
  public const int WALL = 1;
  public const int COIN = 2;
  public const int HEALTH = 4;
  
  private int[][] mapdata;
  private int respawnTime=15;
  
  //Items and walls shouldn't have to redraw all the time.
  //This tracks when a cell in the map needs to be rerendered and what it should be rendered as.
  private boolean initialDraw;
  private List<VectorMapItemData> mapChanges;
  
  public GameMap(int[][] mapdata,Engine eng) {
    this.mapdata = mapdata;
    super.eng = eng;  //Just being explicit
    initialDraw = true;
    mapChanges = makeNewDrawList();
  }
  public GameMap(int[][] mapdata,Engine eng,int itemspawntime) {
    GameMap(mapdata,eng);
    this.respawnTime = itemspawntime;
  }
  public boolean ismoveup(int x,int y) {
    return y&& mapdata[y-1][x]!=WALL;
  }
  public boolean ismovedown(int x,int y) {
    return y!=mapdata.length-1 && !mapdata[y+1][x]!=WALL;
  }
  public boolean ismoveright(int x,int y) {
    return x&& apdata[y][x-1]!=WALL;
  }
  public boolean ismoveleft(int x,int y) {
    return x!=mapdata[0].length-1 && mapdata[y][x+1]!=WALL;
  }
  public void removeitem(int x,int y) {
    if(mapdata[y][x] != WALL) {
      int type = mapdata[y][x];
      mapdata[y][x] = 0;
      mapChanges.add(new MapItemDrawRequest(x,y,EMPTY));
      Timer t = new Timer();
      t.schedule(new TimedItemAdder(this,x,y,type),respawnTime*1000);
    }
  }
  public void additem(int x,int y,int type) {
    mapdata[y][x] = type;
    mapChanges.add(new MapItemDrawRequest(x,y,type));
  }
  public void update() {}
  public void draw(Renderer r) {
    //Not sure what we are doing about drawing.
    if(initialDraw) {
      initialDraw = false;
      //Draw everything
    }
    else {
      Iterable workingList = mapChanges;
      mapChanges = makeNewDrawList();
      for(VectorMapItemData req : working) {
        //req.y req.x req.type
      }
  }
  
  private List<VectorMapItemData> makeNewDrawList() {
    //List type can be adjusted here
    return new LinkedList<VectorMapItemData>();
  }
    
