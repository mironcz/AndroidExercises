package cz.android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

class DrawView extends View {

    private char[][] table;

    final private float w, b;

    // кнопка обнуления игры
    final private float btnClearX, btnClearY, btnClearR;

    public DrawView(TicTacToe mainActivity, char[][] table) {
        super(mainActivity);
        this.table = table;
        this.w = super.getWidth() / 3;
        this.b = super.getHeight() / 2;
        this.btnClearX = w*2 + w/2;
        this.btnClearY = b - b/2 - b/3;
        this.btnClearR = w/3;
    }

    public float getW() {
        return w;
    }

    public float getB() {
        return b;
    }

    public float getBtnClearX() {
        return btnClearX;
    }

    public float getBtnClearY() {
        return btnClearY;
    }

    public float getBtnClearR() {
        return btnClearR;
    }

    private void drawExit(Canvas canvas) {
        // рассчитываем размеры и координаты окружности

        // назначаем цвет и толщину и рисуем
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float w = getWidth() / 3;
        float b = getHeight() / 2;
        float btnClearX = w*2 + w/2;
        float btnClearY = b - b/2 - b/3;
        float btnClearR = w/3;

        float btnExitX = w + w-w/2 + w/4;
        float btnExitY = b - b/2 - b/3;
        float btnExitR = w/3;

        // рисуем рамочки
        Paint p = new Paint();
        p.setColor(Color.LTGRAY);
        p.setStrokeWidth(12);
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);

        canvas.drawLine(0, b - w / 2, getWidth(), b - w / 2, p);
        canvas.drawLine(0, b + w / 2, getWidth(), b + w / 2, p);
        canvas.drawLine(w, getHeight() / 2 - getWidth() / 2, w, getHeight() / 2 + getWidth() / 2, p);
        canvas.drawLine(w + w, getHeight() / 2 - getWidth() / 2, w + w, getHeight() / 2 + getWidth() / 2, p);

        drawExit(canvas);

        // рисуем содержимое таблицы
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == 'o') {
                    p.setColor(Color.BLUE);
                    p.setStrokeWidth(25);
                    float x = col * w + w / 2;
                    float y = (float) ((b - w * 1.5) + row * w) + w / 2;
                    canvas.drawCircle(x, y, w / 2, p);
                }
                if (table[row][col] == 'x') {
                    p.setColor(Color.RED);
                    p.setStrokeWidth(25);
                    float x1 = col * w + w / 2;
                    float y1 = (float) ((b - w * 1.5) + row * w) + w / 2;
                    canvas.drawLine(x1 - w/2, y1 + w/2  , x1 + w/2, y1-w/2, p);
                    canvas.drawLine(x1 + w/2, y1 + w/2  , x1 - w/2, y1-w/2, p);
                }
            }
        }
        p.setColor(Color.BLUE);
        p.setStrokeWidth(25);
        canvas.drawCircle(btnClearX, btnClearY, btnClearR, p);
        canvas.drawCircle(btnExitX,btnExitY,btnExitR,p);
        p.setColor(Color.RED);
        canvas.drawArc(btnClearX - btnClearR /2 + btnClearR /4, btnClearY - btnClearR /2 + btnClearR /4,
                btnClearX + btnClearR /4, btnClearY + btnClearR /4,
                45F, 270F, false, p);
        canvas.drawLine(btnExitX - w/3 + w/5 - w/10,btnExitY + w/3 -w/7 ,btnExitX + w/3 - w/7 + w/17,btnExitY - w/3 + w/7,p);
        canvas.drawLine(btnExitX - w/3 + w/5 - w/10,btnExitY - w/3 +w/7,btnExitX + w/3 - w/7 + w/17,btnExitY + w/3 - w/7,p);
    }
}
