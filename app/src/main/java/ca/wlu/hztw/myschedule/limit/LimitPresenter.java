package ca.wlu.hztw.myschedule.limit;

import ca.wlu.hztw.myschedule.data.LimitRepository;

public class LimitPresenter {
    private LimitRepository repository;

    public LimitPresenter(LimitRepository repository){
        this.repository = repository;
    }

    public String getDate(int pos){
        return repository.getDate(pos);
    }

    public String getTime(int pos){
        return repository.getTime(pos);
    }

    public void addNewLimit(){

    }
}
