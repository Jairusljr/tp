package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.category.Category;
import seedu.duke.category.FoodCategory;
import seedu.duke.category.TransportCategory;
import seedu.duke.category.EntertainmentCategory;
import seedu.duke.category.UtilitiesCategory;
import seedu.duke.category.OtherCategory;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CategoryTest {

    @Test
    void fromString_food_returnsFoodCategory() {
        assertInstanceOf(FoodCategory.class, Category.fromString("FOOD"));
    }

    @Test
    void fromString_transport_returnsTransportCategory() {
        assertInstanceOf(TransportCategory.class, Category.fromString("transport"));
    }

    @Test
    void fromString_entertainment_returnsEntertainmentCategory() {
        assertInstanceOf(EntertainmentCategory.class, Category.fromString("entertainment"));
    }

    @Test
    void fromString_utilities_returnsUtilitiesCategory() {
        assertInstanceOf(UtilitiesCategory.class, Category.fromString("utilities"));
    }

    @Test
    void fromString_other_returnsOtherCategory() {
        assertInstanceOf(OtherCategory.class, Category.fromString("other"));
    }

    @Test
    void fromString_invalidInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Category.fromString("HELLO"));
    }

    @Test
    void fromString_caseInsensitive_returnsCorrectCategory() {
        assertInstanceOf(FoodCategory.class, Category.fromString("food"));
        assertInstanceOf(FoodCategory.class, Category.fromString("Food"));
        assertInstanceOf(FoodCategory.class, Category.fromString("fOoD"));
    }

    @Test
    void isValid_validCategories_returnsTrue() {
        assertTrue(Category.isValid("FOOD"));
        assertTrue(Category.isValid("TRANSPORT"));
        assertTrue(Category.isValid("ENTERTAINMENT"));
        assertTrue(Category.isValid("UTILITIES"));
        assertTrue(Category.isValid("OTHER"));
    }

    @Test
    void isValid_invalidCategories_returnsFalse() {
        assertFalse(Category.isValid("FOO"));
        assertFalse(Category.isValid("hello"));
    }

    @Test
    void isValid_caseInsensitive_returnsTrue() {
        assertTrue(Category.isValid("food"));
        assertTrue(Category.isValid("Food"));
        assertTrue(Category.isValid("fOod"));
    }

    @Test
    void compareTo_categoryOrder_correctSortOrder() {
        Category food = Category.fromString("FOOD");
        Category transport = Category.fromString("TRANSPORT");
        Category entertainment = Category.fromString("ENTERTAINMENT");
        Category utilities = Category.fromString("UTILITIES");
        Category other = Category.fromString("OTHER");

        assertTrue(food.compareTo(transport) < 0);
        assertTrue(transport.compareTo(entertainment) < 0);
        assertTrue(entertainment.compareTo(utilities) < 0);
        assertTrue(utilities.compareTo(other) < 0);
    }

    @Test
    void toString_returnsCorrectName() {
        assertEquals("FOOD", Category.fromString("FOOD").toString());
        assertEquals("TRANSPORT", Category.fromString("TRANSPORT").toString());
        assertEquals("ENTERTAINMENT", Category.fromString("ENTERTAINMENT").toString());
        assertEquals("UTILITIES", Category.fromString("UTILITIES").toString());
        assertEquals("OTHER", Category.fromString("OTHER").toString());
    }
}
