/*
 * Copyright (c) 2019 Alex Wood.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package cc.untar.furiosa.core.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cc.untar.furiosa.core.TestConfiguration;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class DriveStateTest {

    @Autowired
    private Validator validator;

    /**
     * Handling status can never go below -6
     */
    @Test
    public void testMinimumHandlingStatus() {
        DriveState s = new DriveState();
        s.setHandlingStatus(-10);

        Set<ConstraintViolation<DriveState>> violations = validator.validate(s);
        assertFalse(violations.isEmpty());
    }

}
