package com.diogocapela.javafxboiler.libs;

import javafx.scene.layout.Pane;

import java.util.List;

public class FxPageSwitcher {

    private List<FxPage> pages;
    private String currentPage;
    private MainPane pane;

    public FxPageSwitcher(MainPane pane, List<FxPage> pages) {
        this.pane = pane;
        this.pages = pages;
    }

    public void showPage(String page) {

        try {
            FxPage selectedPage = pages.stream()
                    .filter((pg) -> pg.getPageName() == page)
                    .findFirst()
                    .get();

            if (selectedPage == null) {
                System.out.println("FxPageSwitcher: Can't find page " + page);
                return;
            }
            String viewFile = selectedPage.getPageFile();
            Pane view = new FxView(viewFile).get();
            pane.setPage(view);
        } catch (Exception e) {
            System.out.println("FxPageSwitcher: No page " + page + " please check FxPageSwitcher.");
        }
    }

}
