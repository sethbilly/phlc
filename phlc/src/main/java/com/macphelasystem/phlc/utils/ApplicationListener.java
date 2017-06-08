package com.macphelasystem.phlc.utils;

import com.macphelasystem.phlc.jsf.services.UserSession;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;

@Named
@RequestScoped
public class ApplicationListener implements Serializable, PhaseListener
{

    @Inject
    private UserSession userSession;

    @Override
    public void afterPhase(PhaseEvent event)
    {
        FacesContext facesContext = event.getFacesContext();

        String viewId = facesContext.getViewRoot().getViewId();

        if (userSession != null)
        {
            try
            {
                if (viewId.contains("secure"))
                {
                    if (!userSession.isLoggedIn())
                    {
                        Faces.redirect(Faces.getRequestContextPath() + AppPages.LOGIN);
                    }
                }

            } catch (Exception e)
            {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void beforePhase(PhaseEvent event)
    {
    }

    @Override
    public PhaseId getPhaseId()
    {
        return PhaseId.ANY_PHASE;
    }
}
