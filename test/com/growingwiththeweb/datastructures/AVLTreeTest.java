package com.growingwiththeweb.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class AVLTreeTest extends BaseBinarySearchTreeTest {
    @Before
    @Override
    public void setUp() {
        tree = new AVLTree<Integer>();
    }
}
