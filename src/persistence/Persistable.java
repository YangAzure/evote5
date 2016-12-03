package persistence;

public interface Persistable {

	public long getId();

	public void setId(long id);

	public boolean isPersistent();

};
