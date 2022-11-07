import { Component, OnInit } from '@angular/core';
import * as d3 from 'd3';
import { HierarchyNode } from 'd3';
import { INode } from 'src/types';

@Component({
  selector: 'app-tracer',
  templateUrl: './tracer.component.html',
  styleUrls: ['./tracer.component.css'],
})
export class TracerComponent implements OnInit {
  constructor() {} // TODO make width and height input

  ngOnInit(): void {
  }



  createDendogram(): void {
    const width = 960;
    const height = 960;
    const margin = { top: 0, right: 0, left: 0, bottom: 0 };
    const nodeWidth = 150;
    const nodeHeight = 80;



    var svg = d3
      .select('#tracer')
      .append('svg')
      // .attr('width', width)
      // .attr('height', height)
      .attr("viewBox", [0, 0, width, height])
      // .append('g')
      // .attr('transform', `translate(${margin.left},0)`);

    const g = svg.append("g")
      .attr("cursor", "grab")
      .attr('transform', `translate(${margin.left},0)`);

    function zoomed({transform}:any) {
      g.attr("transform", transform);
     }

    const zoom  = d3.zoom()
    .extent([[0, 0], [width, height]])
    .scaleExtent([1, 8])
    .on("zoom", zoomed);

    svg.call(zoom);


    let line = d3
      .line()
      .x((d:any) => d.y)
      .y((d:any) =>d.x)
      .curve(d3.curveStep);


    d3.json(
      'https://raw.githubusercontent.com/holtzy/D3-graph-gallery/master/DATA/data_dendrogram.json'
    ).then(function (data:any) {
      // Create the cluster layout:
      const cluster = d3.cluster().nodeSize([nodeWidth,nodeHeight]).size([height, width -nodeWidth- 100]); // 100 is the margin I will have on the right side

      // Give the data to this cluster layout:
      const root = d3.hierarchy(data, function (d: any) {
        return d.children;
      });
      cluster(root);

      svg.selectAll('path')
        .data( root.links() )
        .join('path')
        .attr("d", ((d:any)=>line([d.source,d.target])))
        .style("fill", 'none')
        .attr("stroke", '#ccc')

      // Add the links between nodes:
      // svg.selectAll('path')
      //   .data( root.descendants().slice(1) )
      //   .join('path')
      //   .attr("d", function(d:any) {
      //       return "M" + d.y + "," + d.x
      //               + "C" + (d.parent.y + 50) + "," + d.x
      //               + " " + (d.parent.y + 150) + "," + d.parent.x // 50 and 150 are coordinates of inflexion, play with it to change links shape
      //               + " " + d.parent.y + "," + d.parent.x;
      //             })
      //   .style("fill", 'none')
      //   .attr("stroke", '#ccc')

      // Add a circle for each node.
      svg
        .selectAll('g')
        .data(root.descendants())
        .join('g')
        .attr('transform', (d: any) => `translate(${d.y},${d.x-nodeHeight/2})`)
        .append('rect')
        .attr('width', nodeWidth)
        .attr('height', nodeHeight)
        .style('fill', '#69b3a2')
        .attr('stroke', 'black')
        .style('stroke-width', 2);

        svg
        .selectAll('g')
        .data(root.descendants())
        // .join('g')
        // .attr('transform', (d: any) => `translate(${nodeWidth/2},${d.x-nodeHeight/2})`)
        .append('g')
        .attr('transform', (d: any) => `translate(${nodeWidth/2},${nodeHeight/2})`)
        .append('text')
        .text((d:any)=>{ console.log(d); return d.data.name})
        .style('text-anchor', 'middle')
        .style('font-size', 'large');



      // svg.selectAll("g")
      //       .append("text")
      //       .text("teste")
    });
  }

  renderFromData() {}
}
