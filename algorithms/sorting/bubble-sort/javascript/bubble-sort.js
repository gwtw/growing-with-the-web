'use strict';

function bubbleSort(array) {
    var i, j;
    for (i = 0; i < array.length - 1; i++) {
        for (j = 1; j < array.length - i; j++) {
            if (array[j - 1] > array[j]) {
                swap(array, j, j - 1);
            }
        }
    }
    return array;
}

function swap(list, a, b) {
    var temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}
