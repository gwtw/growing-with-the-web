'use strict';

function heapsort(array) {
    var heapSize = array.length;
    buildHeap(array, heapSize);
    while (heapSize > 1) {
        swap(array, 0, heapSize - 1);
        heapSize--;
        heapify(array, heapSize, 0);
    }
    return array;
}

function buildHeap(array, heapSize) {
    var i;
    for (i = Math.floor(array.length / 2); i >= 0; i--)
        heapify(array, heapSize, i);
}

function heapify(array, heapSize, i) {
    var left = i * 2 + 1;
    var right = i * 2 + 2;
    var largest;
    if (left < heapSize && array[left] > array[i])
        largest = left;
    else
        largest = i;
    if (right < heapSize && array[right] > array[largest])
        largest = right;
    if (largest != i) {
        swap(array, i, largest);
        heapify(array, heapSize, largest);
    }
}

function swap(list, a, b) {
    var temp = list[a];
    list[a] = list[b];
    list[b] = temp;
}
