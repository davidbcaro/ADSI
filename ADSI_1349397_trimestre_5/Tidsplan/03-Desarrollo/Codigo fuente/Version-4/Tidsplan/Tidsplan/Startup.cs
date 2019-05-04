using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Tidsplan.Startup))]
namespace Tidsplan
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
