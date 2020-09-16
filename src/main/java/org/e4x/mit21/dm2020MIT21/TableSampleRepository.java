 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.e4x.mit21.dm2020MIT21;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roman
 */
@Repository
public interface TableSampleRepository extends JpaRepository<TableSample, Integer> {
    
}
