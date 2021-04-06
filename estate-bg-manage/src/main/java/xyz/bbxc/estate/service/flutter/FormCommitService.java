package xyz.bbxc.estate.service.flutter;/**
 * @Classname FormCommitService
 * @Description TODO
 * @Date 2021-4-4 12:08
 * @Created by 白白小草
 */

import xyz.bbxc.estate.damain.Repaired;

import java.util.List;

/**
 * @Classname FormCommitService
 * @Description TODO
 * @Date 2021-4-4 12:08
 * @Created by 白白小草
 */
public interface FormCommitService {

    int add(Repaired repaired);

    public List<Repaired> searchAll();
}
