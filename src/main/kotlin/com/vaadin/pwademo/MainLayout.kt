package com.vaadin.pwademo

import com.github.vok.karibudsl.flow.div
import com.vaadin.flow.component.HasElement
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.page.BodySize
import com.vaadin.flow.component.page.Viewport
import com.vaadin.flow.router.RouterLayout
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import com.vaadin.pwademo.components.*

@BodySize(width = "100vw", height = "100vh")
@HtmlImport("frontend://styles.html")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes")
@Theme(Lumo::class)
class MainLayout : AppHeaderLayout(), RouterLayout {
  private val content: Div

  init {
    appHeader {
      appToolbar {
        title.text = "Vaadin Kotlin PWA Demo"
        paperIconButton(VaadinIcon.FILE_REMOVE) {
          addClickListener {
            Notification.show("A toast!", 3000, Notification.Position.BOTTOM_CENTER)
          }
        }
      }
    }
    appDrawer {
      navMenuItem(VaadinIcon.LIST, "Task List")
      navMenuItem(VaadinIcon.COG, "Settings")
      navMenuItem(VaadinIcon.QUESTION, "About")
    }
    content = div {
      setSizeFull()
      classNames.add("app-content")
    }
  }

  override fun showRouterLayoutContent(content: HasElement) {
    this.content.element.appendChild(content.element)
  }
}
