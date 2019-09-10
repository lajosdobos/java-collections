package eu.dorsum.training.collections.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import eu.dorsum.training.collections.core.Employee;
import eu.dorsum.training.collections.core.EmployeeUtil;

public class CollectionTest {

	private List<Employee> employeeList;
	private Map<Integer, List<String>> resultMap;
	private Set<Integer> resultSet;
	private Set<String> resultNames;
	private double avgSalary;
	
	@Before
	public void initResults() {
		//data for all the lessons
		employeeList = new ArrayList<>();
		employeeList.add(new Employee("Denis", 25, 50000.0));
		employeeList.add(new Employee("Abraham", 24, 100.0));
		employeeList.add(new Employee("Mike", 24, 120.0));
		employeeList.add(new Employee("George", 45, 300.0));
    	
    	//result for task-3
    	resultSet = new HashSet<>(Arrays.asList(24,25,45));
    	    	
    	//result for task-4
    	avgSalary = 12630.0;
    		
    	//result for task-5
    	resultNames = new TreeSet<>();
    	resultNames.add("Abraham");
    	resultNames.add("Denis");
    	resultNames.add("George");
    	resultNames.add("Mike");

    	//result for task-6
    	
		//result for task-7
		resultMap = new HashMap<>();
    	List<String> age24 = Arrays.asList("Abraham", "Mike");
    	List<String> age25 = Arrays.asList("Denis");
    	List<String> age45 = Arrays.asList("George");
    	resultMap.put(24, age24);
    	resultMap.put(25, age25);
    	resultMap.put(45, age45);	
	}

	/**
	 * Return the employee with the highest salary
	 * 
	 */
    @Test
    public void returnEmpNameWithHighestSalary(){         
        String expectedName = "Denis";
        assertEquals(expectedName, EmployeeUtil.getEmpNameWithHighestSalary(employeeList));
    }
     
    /**
     * Return the employee as an object with the highest salary
     */
    @Test
    public void returnEmpWithHighestSalary() {         
        Employee expectedEmpObj = employeeList.get(0);
        assertEquals(expectedEmpObj, EmployeeUtil.getHighestPaidEmployee(employeeList));
    }
    
    /**
     * Return every possible age from the list 
     */
    @Test
    public void returnSetWithAllTheAges() {
    	assertTrue(CollectionUtils.isEqualCollection(resultSet, EmployeeUtil.getAgesAsSet(employeeList)));    
    }
    
    /**
     * Calculate the average salary
     */
    @Test
    public void returnAvgSalary() {
    	assertEquals(avgSalary, EmployeeUtil.getAvgSalary(employeeList), 0);
    }
    
    /**
     * 
     *Collect and sort names alphabetical  
     */
    @Test
    public void returnOrderedNames() {	
    	assertTrue(CollectionUtils.isEqualCollection(resultNames, EmployeeUtil.getOrderedNames(employeeList)));
    }
    
    /**
     * Transform the list to a map like this
     * key - age (integer)
     * value - all the names of the people in the same age
     * for example:
     * 		24 - Abraham, Mike
     * 		25 - Denis
     */
    @Test
    public void returnNamesGroupedByAge() {
    	assertTrue(areEqualWithListValue(EmployeeUtil.getEmployeesAsMap(employeeList), resultMap));      
    }
    
    /**
     * 
     * return names group by enum values
     * Create a Book enum class first, and create a new variable in the Employee class as 'favBook'
     */
    public void enumTest() {
    	
    }
    
    private boolean areEqualWithListValue(Map<Integer, List<String>> first, Map<Integer, List<String>> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
          .allMatch(e -> e.getValue().containsAll(second.get(e.getKey())) &&
        		  second.get(e.getKey()).containsAll(e.getValue()));
    }
    
}
