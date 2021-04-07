package xyz.bbxc.estate.service.flutter;

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

    List<Repaired> searchAllByName(String name);

    List<Repaired> searchAllByOwnerName(String name);
}
