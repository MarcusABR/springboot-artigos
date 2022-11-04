export default class Graph {
    constructor() {
      this.edgeList = new Map();
      this.nodeList = new Map();
      this.nodeByHeight = [];
      this.visited = [];
      this.height = 0;
    }

    get getEdgeList(){
        return this.edgeList;
    }

    get getNodeList(){
        return this.nodeList;
    }

    get getNodeByHeight() {
        return this.nodeByHeight
    }
  
    create(data, idName, listName){
      this.convertData(data, idName, listName);
      this.update(idName);
    }
  
    convertData(data, idName, listName) {
      const id = data[idName];
  
      if (!this.nodeList.get(id)) {
        const {[listName]: remove, ...obj} = data
        this.nodeList.set(id, obj)
        this.edgeList.set(id, []);
      }
  
      for (let child of data[listName]) {
        this.edgeList.get(id).push(child[idName]);
        this.convertData(child, idName, listName);
      }
    }
  
    depthFirstSearch(key, height, idName){
      if(height > this.height ) this.height = height;
      if(this.visited[key]) return;
  
      this.visited.push(key);
      if(!this.nodeByHeight[height-1] ) this.nodeByHeight[height-1] = []
      this.nodeByHeight[height-1].push(this.nodeList.get(key))
  
      for( let v of this.edgeList.get(key)){ 
        this.depthFirstSearch(v, height+1, idName)
      }
    }

    update(idName){
      this.visited = [];
      this.height = 0
      const [ firstKey ] = this.edgeList.keys();
      this.depthFirstSearch(firstKey, 1, idName)
    }
  
  
  }

return (
    <svg width={width} height={height} id="gfg">
      <g transform={`translate(${margin.left},${margin.top})`}>
        {graph.getNodeByHeight.map((d, i) => {
          const xScale = scaleBand()
            .domain(d.map((d) => d.name))
            .range([0, height]);
          return (
            <g transform={`translate(${xScale.bandwidth() / 2})`}>
              {d.map((node) => (
                <rect
                  key={d.name}
                  x={xScale(node.name)}
                  y={yScale(i)}
                  width={50}
                  height={50}
                />
              ))}
            </g>
          );
        })}
      </g>
    </svg>
  );
  
