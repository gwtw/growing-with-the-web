'use strict';

function mergeSort(array) {
    if (array.length <= 1)
        return array;
    
    var i;
    var middle = Math.floor(array.length / 2);
    var left = new Array(middle);
    var right = new Array(array.length - middle);
    
    for (i = 0; i < left.length; i++)
        left[i] = array[i];
    for (i = 0; i < right.length; i++)
        right[i] = array[i + left.length];
    
    return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
    var result = new Array(left.length + right.length);
    var leftIndex = 0;
    var rightIndex = 0;
    var resultIndex = 0;
    
    while (leftIndex < left.length || rightIndex < right.length) {
        if (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        } else if (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        } else if (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
    }
    return result;
}
