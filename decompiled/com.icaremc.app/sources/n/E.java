package n;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import t.C0661j;

/* loaded from: classes.dex */
public class E extends j.x implements Menu {

    /* renamed from: c, reason: collision with root package name */
    public final n f5210c;

    public E(Context context, n nVar) {
        super(context);
        if (nVar != null) {
            this.f5210c = nVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return f(this.f5210c.a(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        } else {
            menuItemArr2 = null;
        }
        MenuItem[] menuItemArr3 = menuItemArr2;
        int addIntentOptions = this.f5210c.addIntentOptions(i4, i5, i6, componentName, intentArr, intent, i7, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i8 = 0; i8 < length; i8++) {
                menuItemArr[i8] = f(menuItemArr3[i8]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f5210c.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        C0661j c0661j = (C0661j) this.f5017b;
        if (c0661j != null) {
            c0661j.clear();
        }
        this.f5210c.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f5210c.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i4) {
        return f(this.f5210c.findItem(i4));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i4) {
        return f(this.f5210c.getItem(i4));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f5210c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return this.f5210c.isShortcutKey(i4, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i4, int i5) {
        return this.f5210c.performIdentifierAction(i4, i5);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        return this.f5210c.performShortcut(i4, keyEvent, i5);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i4) {
        if (((C0661j) this.f5017b) != null) {
            int i5 = 0;
            while (true) {
                C0661j c0661j = (C0661j) this.f5017b;
                if (i5 >= c0661j.f6196h) {
                    break;
                }
                if (((D.a) c0661j.e(i5)).getGroupId() == i4) {
                    ((C0661j) this.f5017b).f(i5);
                    i5--;
                }
                i5++;
            }
        }
        this.f5210c.removeGroup(i4);
    }

    @Override // android.view.Menu
    public final void removeItem(int i4) {
        if (((C0661j) this.f5017b) != null) {
            int i5 = 0;
            while (true) {
                C0661j c0661j = (C0661j) this.f5017b;
                if (i5 >= c0661j.f6196h) {
                    break;
                }
                if (((D.a) c0661j.e(i5)).getItemId() == i4) {
                    ((C0661j) this.f5017b).f(i5);
                    break;
                }
                i5++;
            }
        }
        this.f5210c.removeItem(i4);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i4, boolean z, boolean z3) {
        this.f5210c.setGroupCheckable(i4, z, z3);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i4, boolean z) {
        this.f5210c.setGroupEnabled(i4, z);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i4, boolean z) {
        this.f5210c.setGroupVisible(i4, z);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.f5210c.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f5210c.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4) {
        return this.f5210c.addSubMenu(i4);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        return this.f5210c.addSubMenu(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4) {
        return f(this.f5210c.add(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return this.f5210c.addSubMenu(i4, i5, i6, i7);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return f(this.f5210c.a(i4, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, int i7) {
        return f(this.f5210c.add(i4, i5, i6, i7));
    }
}
