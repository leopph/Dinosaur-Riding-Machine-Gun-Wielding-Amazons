package commands;

import core.Data;
import entities.Amazon;
import entities.Dinoszaurusz;
import items.Item;

public class LookAround implements Command {
  public String execute(String[] strs, Data data) {
    if (strs.length == 1) {
      if (((Select)data.getCommands().get("select")).getSelection() != null) {
        if (((Select)data.getCommands().get("select")).getSelection().getHP() > 0.0D)
          for (int i = 0; i < (data.getWorld().getTiles()).length; i++) {
            for (int j = 0; j < (data.getWorld().getTiles()[0]).length; j++) {
              if (data.getWorld().getTiles()[i][j].containsAmazon(((Select)data.getCommands().get("select")).getSelection())) {
                String ret = "";
                String temp = "";
                for (Amazon amazon : data.getWorld().getTiles()[i][j].getAmazonSet()) {
                  if (amazon != ((Select)data.getCommands().get("select")).getSelection())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                } 
                for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i][j].getDinoszauruszList())
                  temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                for (Item item : data.getWorld().getTiles()[i][j].getItemList())
                  temp = temp.concat("" + item + ", "); 
                if (temp.equals("")) {
                  ret = ret.concat("Az aktuális mezőn nincs semmi.\n");
                } else {
                  ret = ret.concat("Az aktuális mezőn: " + temp.substring(0, temp.length() - 2) + ".\n");
                  temp = "";
                } 
                if (i + 1 < data.getWorld().getSize()) {
                  for (Amazon amazon : data.getWorld().getTiles()[i + 1][j].getAmazonSet())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                  for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i + 1][j].getDinoszauruszList())
                    temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                  for (Item item : data.getWorld().getTiles()[i + 1][j].getItemList())
                    temp = temp.concat("" + item + ", "); 
                  if (temp.equals("")) {
                    ret = ret.concat((data.getPlayerMarker() ? "Délre" : "Északra") + " nincs semmi.\n");
                  } else {
                    ret = ret.concat((data.getPlayerMarker() ? "Délre: " : "Északra: ") + (data.getPlayerMarker() ? "Délre: " : "Északra: ") + ".\n");
                    temp = "";
                  } 
                } 
                if (i + 1 < data.getWorld().getSize() && j + 1 < data.getWorld().getSize()) {
                  for (Amazon amazon : data.getWorld().getTiles()[i + 1][j + 1].getAmazonSet())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                  for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i + 1][j + 1].getDinoszauruszList())
                    temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                  for (Item item : data.getWorld().getTiles()[i + 1][j + 1].getItemList())
                    temp = temp.concat("" + item + ", "); 
                  if (temp.equals("")) {
                    ret = ret.concat((data.getPlayerMarker() ? "Dél-nyugatra " : "Észak-keletre ") + "nincs semmi.\n");
                  } else {
                    ret = ret.concat((data.getPlayerMarker() ? "Dél-nyugatra: " : "Észak-keletre: ") + (data.getPlayerMarker() ? "Dél-nyugatra: " : "Észak-keletre: ") + ".\n");
                    temp = "";
                  } 
                } 
                if (j + 1 < data.getWorld().getSize()) {
                  for (Amazon amazon : data.getWorld().getTiles()[i][j + 1].getAmazonSet())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                  for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i][j + 1].getDinoszauruszList())
                    temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                  for (Item item : data.getWorld().getTiles()[i][j + 1].getItemList())
                    temp = temp.concat("" + item + ", "); 
                  if (temp.equals("")) {
                    ret = ret.concat((data.getPlayerMarker() ? "Nyugatra " : "Keletre ") + "nincs semmi.\n");
                  } else {
                    ret = ret.concat((data.getPlayerMarker() ? "Nyugatra: " : "Keletre: ") + (data.getPlayerMarker() ? "Nyugatra: " : "Keletre: ") + ".\n");
                    temp = "";
                  } 
                } 
                if (i - 1 >= 0 && j + 1 < data.getWorld().getSize()) {
                  for (Amazon amazon : data.getWorld().getTiles()[i - 1][j + 1].getAmazonSet())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                  for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i - 1][j + 1].getDinoszauruszList())
                    temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                  for (Item item : data.getWorld().getTiles()[i - 1][j + 1].getItemList())
                    temp = temp.concat("" + item + ", "); 
                  if (temp.equals("")) {
                    ret = ret.concat((data.getPlayerMarker() ? "Észak-nyugatra " : "Dél-keletre ") + "nincs semmi.\n");
                  } else {
                    ret = ret.concat((data.getPlayerMarker() ? "Észak-nyugatra: " : "Dél-keletre: ") + (data.getPlayerMarker() ? "Észak-nyugatra: " : "Dél-keletre: ") + ".\n");
                    temp = "";
                  } 
                } 
                if (i - 1 >= 0) {
                  for (Amazon amazon : data.getWorld().getTiles()[i - 1][j].getAmazonSet())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                  for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i - 1][j].getDinoszauruszList())
                    temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                  for (Item item : data.getWorld().getTiles()[i - 1][j].getItemList())
                    temp = temp.concat("" + item + ", "); 
                  if (temp.equals("")) {
                    ret = ret.concat((data.getPlayerMarker() ? "Északra " : "Délre ") + "nincs semmi.\n");
                  } else {
                    ret = ret.concat((data.getPlayerMarker() ? "Északra: " : "Délre: ") + (data.getPlayerMarker() ? "Északra: " : "Délre: ") + ".\n");
                    temp = "";
                  } 
                } 
                if (i - 1 >= 0 && j - 1 >= 0) {
                  for (Amazon amazon : data.getWorld().getTiles()[i - 1][j - 1].getAmazonSet())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                  for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i - 1][j - 1].getDinoszauruszList())
                    temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                  for (Item item : data.getWorld().getTiles()[i - 1][j - 1].getItemList())
                    temp = temp.concat("" + item + ", "); 
                  if (temp.equals("")) {
                    ret = ret.concat((data.getPlayerMarker() ? "Észak-keletre " : "Dél-nyugatra ") + "nincs semmi.\n");
                  } else {
                    ret = ret.concat((data.getPlayerMarker() ? "Észak-keletre: " : "Dél-nyugatra: ") + (data.getPlayerMarker() ? "Észak-keletre: " : "Dél-nyugatra: ") + ".\n");
                    temp = "";
                  } 
                } 
                if (j - 1 >= 0) {
                  for (Amazon amazon : data.getWorld().getTiles()[i][j - 1].getAmazonSet())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                  for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i][j - 1].getDinoszauruszList())
                    temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                  for (Item item : data.getWorld().getTiles()[i][j - 1].getItemList())
                    temp = temp.concat("" + item + ", "); 
                  if (temp.equals("")) {
                    ret = ret.concat((data.getPlayerMarker() ? "Keletre " : "Nyugatra ") + "nincs semmi.\n");
                  } else {
                    ret = ret.concat((data.getPlayerMarker() ? "Keletre: " : "Nyugatra: ") + (data.getPlayerMarker() ? "Keletre: " : "Nyugatra: ") + ".\n");
                    temp = "";
                  } 
                } 
                if (i + 1 < data.getWorld().getSize() && j - 1 >= 0) {
                  for (Amazon amazon : data.getWorld().getTiles()[i + 1][j - 1].getAmazonSet())
                    temp = temp.concat("" + amazon + amazon + ", "); 
                  for (Dinoszaurusz dinoszaurusz : data.getWorld().getTiles()[i + 1][j - 1].getDinoszauruszList())
                    temp = temp.concat("" + dinoszaurusz + dinoszaurusz + ", "); 
                  for (Item item : data.getWorld().getTiles()[i + 1][j - 1].getItemList())
                    temp = temp.concat("" + item + ", "); 
                  if (temp.equals("")) {
                    ret = ret.concat((data.getPlayerMarker() ? "Dél-keletre " : "Észak-nyugatra ") + "nincs semmi.\n");
                  } else {
                    ret = ret.concat((data.getPlayerMarker() ? "Dél-keletre: " : "Észak-nyugatra: ") + (data.getPlayerMarker() ? "Dél-keletre: " : "Észak-nyugatra: ") + ".\n");
                  } 
                } 
                return ret;
              } 
            } 
          }  
        return ((Select)data.getCommands().get("select")).getSelection().getNev() + " nem is él!\n";
      } 
      return "Válasszá ki valakit!\n";
    } 
    return "Nem megfelelő a gyökérségek száma heló!\n";
  }
}
