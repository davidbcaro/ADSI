using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(ChronoOfTime.Startup))]
namespace ChronoOfTime
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
