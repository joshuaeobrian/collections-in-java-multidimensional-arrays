package com.theironyard;

import net.doughughes.testifier.exception.CannotAccessMethodException;
import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.exception.CannotInvokeMethodException;
import net.doughughes.testifier.exception.MethodIsNotStaticException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.test.TestifierTest;
import net.doughughes.testifier.util.Invoker;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MatrixKatasTest extends TestifierTest{

    @Test
    public void testCreateProductTable3By5() {
        /* arrange */

        /* act */
        int[][] result = new int[0][];
        try {
            result = (int[][]) Invoker.invokeStatic(MatrixKatas.class, "createProductTable", 3, 5);
        } catch (MethodIsNotStaticException | CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("The array that contains arrays of ints should have a length of 3",
                result.length, equalTo(3));
        for(int[] set : result){
            assertThat("The arrays of ints contained in the array a length of 5",
                    set.length, equalTo(5));
        }
    }

    @Test
    public void testCreateProductTable3By4Values() {
        /* arrange */

        /* act */
        int[][] result = new int[0][];
        try {
            result = (int[][]) Invoker.invokeStatic(MatrixKatas.class, "createProductTable", 3, 4);
        } catch (MethodIsNotStaticException |CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        for(int x = 0 ; x < 3 ; x++){
            for(int y = 0 ; y < 4 ; y++){
                assertThat(x + " * " + y + " should equal " + (x * y),
                        result[x][y], equalTo(x * y));
            }
        }

    }

    @Test
    public void testCreateProductTableStructure(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("createProductTable", int.class, int.class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("The createProductTable() method should contain nested for loops.",
                source, RegexMatcher.matches("^.*?ForStmt.*?BlockStmt.*?ForStmt.*?BlockStmt.*?/BlockStmt.*?/ForStmt.*?/BlockStmt.*?/ForStmt.*?$"));
    }
}