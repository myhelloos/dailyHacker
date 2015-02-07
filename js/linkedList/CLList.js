function Node(element) {
	this.element = element;
	this.next = null;
}

function CLList() {
	this.head = new Node("head");
	this.head.next = this.head;
	this.find = find;
	this.insert = insert;
	this.display = display;
	this.findPrevious = findPrevious;
	this.remove = remove;
}

function find(item) {
	var currNode = this.head;
	while (!(currNode.next == this.head) && (currNode.element != item)) {
		currNode = currNode.next;
	}
	if (currNode.element == item)
		return currNode;
	return null;
}

function findPrevious(item) {
    var currNode = this.head;
    while (!(currNode.next == this.head) && (currNode.next.element != item)) {
        currNode = currNode.next;
    }
    if (currNode.next.element == item) {
        return currNode;
    }
    return null;
}

function insert(newElement, item) {
    var newNode = new Node(newElement);
    var currNode = this.find(item);
    if (currNode != null) {
        newNode.next = currNode.next;
        currNode.next = newNode;
    }
}

function remove(item) {
    var prevNode = this.findPrevious(item);
    if (!(prevNode.next == null)) {
        var currNode = prevNode.next;
        prevNode.next = currNode.next;
        currNode.next = null;
    }
}

function display() {
    var currNode = this.head;
    while (!(currNode.next == this.head)) {
        print(currNode.next.element);
        currNode = currNode.next;
    }
}
