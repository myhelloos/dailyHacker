/*******************************************************************************
                            Graph Definition
A graph consists of a set of vertices and a set of edges.
Edges are defined as a pair (v1, v2), where v1 and v2 are two vertices in a graph.
A vertex can also have a weight, which is sometimes called a cost.

                            Order Graph vs Graph
A graph whose pairs are ordered is called a directed graph, or just a digraph.
If a graph is not ordered, it is called an unordered graph, or just a graph.

                                    Path
A path is a sequence of vertices in a graph such that all vertices in the path
    are connected by edges.

                                Legth of Path
The length of a path is the number of edges from the first vertex in the path to
    the last vertex.

                                Loop and its Length
A path can also consist of a vertex to itself, which is called a loop.
Loops have a length of 0.

                                    Cycle
A cycle is a path with at least one edge whose first and last vertices are
    the same.

                                Simple Cycle
A simple cycle is one with no repeated edges or vertices for both directed and
    undirected graphs.

                                General Cycle
Paths that repeat other vertices besides the first and last vertices are called
    general cycles.

                                Strongly Connected Vertices
Two vertices are considered strongly connected if there is a path from the first
    vertex to the second vertex, and vice versa.

                                Strongly Connected Graph
If the graph is a directed graph, and all its vertices are strongly connected,
    then the directed graph is considered strongly connected.
*******************************************************************************/
function Graph(v) {
    this.vertices = v;
    this.vertexList = [];
    this.edges = 0;
    this.adj = [];
    for (var i = 0; i < this.vertices; i++) {
        this.adj[i] = [];
    }
    this.addEdge = addEdge;
    this.showGraph = showGraph;
    this.dfs = dfs;
    this.marked = [];
    for (var i = 0; i < this.vetices; i++) {
        this.marked[i] = false;
    }
    this.bfs = bfs;
    this.edgeTo = [];
    this.pathTo = pathTo;
    this.hasPathTo = hasPathTo;
    this.topSort = topSort;
    this.topSortHelper = topSortHelper;
}

function addEdge(v, w) {
    this.adj[v].push(w);
    this.edges++;
}

/*
function showGraph() {
    for (var i = 0; i < this.vertices; ++i) {
        putstr(i + " -> ");
        for (var j = 0; j < this.vertices; ++j) {
            if (this.adj[i][j] != undefined) {
                putstr(this.adj[i][j] + ' ');
            }
        }
        print();
    }
}
*/

// a new function to display symbolic names instead of numbers
function showGraph() {
    var visited = [];
    for (var i = 0; i < this.vertices; ++i) {
        putstr(this.vertexList[i] + " -> ");
        visited.push(this.vertexList[i]);
        for each (var j in this.adj[i]) {
            if (visited.indexOf(j) < 0) {
                putstr(this.vertexList[j] + ' ');
            }
        }
        print();
        visited.pop();
    }
}

function dfs(v) {
    this.marked[v] = true;
    for each (var w in this.adj[v]) {
        if (!this.marked[w]) {
            this.dfs(w);
        }
    }
}

function bfs(s) {
    var queue = [];
    this.marked[s] = true;
    queue.unshift(s); // add to back of queue
    while (queue.length > 0) {
        var v = queue.shift(); // remove from front of queue
        for each (var w in this.adj[v]) {
            if (!this.marked[w]) {
                this.edgeTo[w] = v;
                this.marked[w] = true;
                queue.unshift(w);
            }
        }
    }
}

function pathTo(v) {
    var source = 0;
    this.bfs(source);
    if (!this.hasPathTo(v)) {
        return undefined;
    }
    var path = [];
    for (var i = v; i != source; i = this.edgeTo[i]) {
        path.push(i);
    }

    path.push(source);
    return path;
}

function hasPathTo(v) {
    return this.marked[v];
}

function topSort() {
    var stack = [];
    var visited = [];
    for (var i = 0; i < this.vertices; i++) {
        visited[i] = false;
    }
    for (var i = 0; i < this.vertices; i++) {
        if (visited[i] == false) {
            this.topSortHelper(i, visited, stack);
        }
    }
    for (var i = 0; i < stack.length; i++) {
            print(this.vertexList[stack[i]]);
    }
}

function topSortHelper(v, visited, stack) {
    visited[v] = true;
    for each(var w in this.adj[v]) {
        if (!visited[w]) {
            this.topSortHelper(w, visited, stack);
        }
    }
    stack.unshift(v);
}
