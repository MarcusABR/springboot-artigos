export default class Graph {
  constructor() {
    this.edgeList = new Map();
    this.nodeList = new Map();
    this.visited = [];
    this.height = 0;
  }

  create(data, idName, listName){
    this.convertData(data, idName, listName);
    this.update(idName);
    console.log(this.nodeList)
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
    this.nodeList.get(key).level = height;

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


import React, { useState, useCallback, useEffect } from "react";
import { scaleBand, scaleLinear, max } from "d3";
import Graph from "./utils/Graph";

const data = {
  name: "node 1",
  children: [
    {
      name: "node 2",
      children: [
        {
          name: "node 4",
          children: [],
        },
      ],
    },
    {
      name: "node 3",
      children: [
        {
          name: "node 5",
          children: [
            {
              name: "node 6",
              children: [],
            },
          ],
        },
      ],
    },
  ],
};
const width = 960;
const height = 500;

const App = () => {
  const graph = new Graph();
  graph.create(data, "name", "children");

  // const xScale = scaleBand()
  //   .domain(data.map((d) => d.name))
  //   .range([0, height]);

  // const yScale = scaleBand()
  //   .domain(data.map((d) => d.name))
  //   .range([0, height]);

  return (
    <svg width={width} height={height}>
      {/* {data.map((d) => (
        <rect
          key={d.Country}
          y={yScale(d.Country)}
          width={xScale(d.Population)}
          height={yScale.bandwidth()}
        />
      ))} */}
    </svg>
  );
};

export default App;
