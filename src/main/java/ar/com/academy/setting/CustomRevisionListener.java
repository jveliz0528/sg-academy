package ar.com.academy.setting;

import org.hibernate.envers.RevisionListener;

import ar.com.academy.audit.Revision;

public class CustomRevisionListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntety) {
		final Revision revision = (Revision) revisionEntety;
	}

}
